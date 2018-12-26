package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UniqueEmailAddresses929Test {
    @Parameterized.Parameters
    public static CheckEmailsItem[] data() {
        return new CheckEmailsItem[]{
                new CheckEmailsItem(new String[] {
                }, 0),
                new CheckEmailsItem(new String[] {
                        "testemail@leetcode.com"
                }, 1),
                new CheckEmailsItem(new String[] {
                        "testemail@leetcode.com",
                        "test.email@leetcode.com"
                }, 1),
                new CheckEmailsItem(new String[] {
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"
                }, 2),
                new CheckEmailsItem(new String[] {
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com",
                        "testemail@lee.tcode.com"
                }, 2),
                new CheckEmailsItem(new String[] {
                        "test.emails+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemaildavid@lee.tcode.com",
                        "testemail@lee.tcode.com"
                }, 4),
        };
    }

    private static class CheckEmailsItem {
        String[] emails;
        int expectedDifferentAddresses;

        CheckEmailsItem(String[] emails, int expectedDifferentAddresses) {
            this.emails = emails;
            this.expectedDifferentAddresses = expectedDifferentAddresses;
        }
    }

    private CheckEmailsItem testItem;

    public UniqueEmailAddresses929Test(CheckEmailsItem item) {
        testItem = item;
    }

    @Test
    public void numUniqueEmails() {
        UniqueEmailAddresses929 solution = new UniqueEmailAddresses929();
        int actualDifferentAddresses = solution.numUniqueEmails(testItem.emails);
        assertThat(actualDifferentAddresses, equalTo(testItem.expectedDifferentAddresses));
    }
}