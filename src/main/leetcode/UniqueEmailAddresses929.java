package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        Set<String> uniqueEmails = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            parseEmail(email, uniqueEmails, sb);
        }
        return uniqueEmails.size();
    }

    private void parseEmail(String str, Set<String> uniqueEmails, StringBuilder sb) {
        char[] letters = str.toCharArray();
        boolean isLocalNamePart = true; // false for domain name part
        boolean ignorePartOfLocalName = false;
        char c;
        for (char letter : letters) {
            c = letter;
            if (isLocalNamePart) {
                if (c == '@') {
                    isLocalNamePart = false;
                    sb.append(c);
                } else if (!ignorePartOfLocalName) {
                    if (c == '+') {
                        ignorePartOfLocalName = true;
                    } else if (c != '.') {
                        sb.append(c);
                    }
                }
            } else {
                sb.append(c);
            }
        }
        String email = sb.toString();
        sb.delete(0, sb.length());
        uniqueEmails.add(email);
    }
}
