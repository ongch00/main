package seedu.address.model.internship.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static seedu.address.testutil.TypicalInterviews.CENTRAL_LIBRARY;
import static seedu.address.testutil.TypicalInterviews.ONLINE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.InterviewBuilder;

/**
 * Tests integration between OfflineInterview and OnlineInterview.
 */
public class InterviewTest {

    @Test
    public void equals() {

        // same values -> returns true
        Interview clbCopy = new InterviewBuilder(CENTRAL_LIBRARY).build();
        assertTrue(CENTRAL_LIBRARY.equals(clbCopy));

        // same object -> returns true
        assertTrue(CENTRAL_LIBRARY.equals(CENTRAL_LIBRARY));

        // null -> returns false
        assertFalse(CENTRAL_LIBRARY.equals(null));

        // different type -> returns false
        assertFalse(CENTRAL_LIBRARY.equals(5));

        // different isOnline -> returns false
        assertFalse(CENTRAL_LIBRARY.equals(ONLINE));

        // different address -> returns false
        Interview editedClb = new InterviewBuilder(CENTRAL_LIBRARY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(CENTRAL_LIBRARY.equals(editedClb));

        // different date -> returns false
        editedClb = new InterviewBuilder(CENTRAL_LIBRARY).withDate(VALID_DATE_AMY).build();
        assertFalse(CENTRAL_LIBRARY.equals(editedClb));

        // different isOnline -> returns false
        editedClb = new InterviewBuilder(CENTRAL_LIBRARY).withIsOnline(true).build();
        assertFalse(CENTRAL_LIBRARY.equals(editedClb));
    }
}
