package seedu.diary.model.internship.predicate;

import static seedu.diary.logic.parser.CliSyntax.PREFIX_ADDRESS;

import java.util.List;
import java.util.function.Predicate;

import seedu.diary.model.internship.InternshipApplication;

/**
 * Tests that a {@code InternshipApplication}'s {@code Address} contains any of the keywords given.
 */
public class AddressContainsKeywordsPredicate implements Predicate<InternshipApplication> {
    private final List<String> keywords;

    public AddressContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(InternshipApplication internshipApplication) {
        if (keywords == null) {
            return true;
        }

        return keywords.stream()
            .anyMatch(keyword -> internshipApplication.getAddress().value.toLowerCase()
                .contains(keyword.toLowerCase()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof AddressContainsKeywordsPredicate // instanceof handles nulls
            && keywords.equals(((AddressContainsKeywordsPredicate) other).keywords)); // state check
    }

    public boolean isNull() {
        return keywords == null;
    }

    @Override
    public String toString() {
        if (isNull()) {
            return PREFIX_ADDRESS.toString();
        }
        return PREFIX_ADDRESS + String.join(" ", keywords);
    }
}
