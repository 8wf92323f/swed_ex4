package com.example.monitorapp.websiteservice.comparison;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Compared two HTML strings by comparing the actual HTML content,
 * i.e. if both websites produce the same website structure, they are equal.
 */
public class HtmlContentStrategy implements Strategy {
    private static final String TEXT_OR_NEWLINE_REGEX = "[\\s\\S]*?";
    private static final String COMMENT_REGEX = "<!--" + TEXT_OR_NEWLINE_REGEX + "-->";
    private static final Pattern COMMENT_PATTERN = Pattern.compile(COMMENT_REGEX);
    private static final String WHITESPACE = "\\s*";
    private static final String TAG_CONTENT = "(" + TEXT_OR_NEWLINE_REGEX + ")";
    private static final String TAG_REGEX = WHITESPACE + "<([A-Za-z][A-Za-z0-9]*)>" + TAG_CONTENT + "</\\1>" + WHITESPACE;
    private static final Pattern TAG_PATTERN = Pattern.compile(TAG_REGEX);

    @Override
    public boolean compare(String html1, String html2) {
        String cleaned1 = formatHTML(html1);
        String cleaned2 = formatHTML(html2);

        return cleaned1.equals(cleaned2);
    }

    private static String formatHTML(String html) {
        Matcher matcher = COMMENT_PATTERN.matcher(html);
        html = matcher.replaceAll("");

        return formatTags(html, "");
    }

    /**
     * Recursively parses bracket tags using regexes
     */
    private static String formatTags(String html, String indentation) {
        StringBuilder builder = new StringBuilder();
        Matcher matcher = TAG_PATTERN.matcher(html);

        int lastIndex = 0;

        while (matcher.find()) {
            // detect text before tag
            if (lastIndex < matcher.start()) {
                String looseText = html.substring(lastIndex, matcher.start());
                builder.append(parseLooseText(looseText, indentation));
            }

            String tagName = matcher.group(1);
            String content = matcher.group(2);

            builder.append(indentation).append("<").append(tagName).append(">");

            String formattedContent = formatTags(content, indentation + "\t");

            if (!formattedContent.isBlank()) {
                builder.append("\n").append(formattedContent).append(indentation);
            }

            builder.append("</").append(tagName).append(">\n");

            lastIndex = matcher.end();
        }

        // detect text at end of parent tag
        if (lastIndex < html.length()) {
            String looseText = html.substring(lastIndex);
            builder.append(parseLooseText(looseText, indentation));
        }

        return builder.toString();
    }

    /**
     * Formats loose tags inside a tag (e.g. "<span>TEXT HERE</span>")
     */
    private static String parseLooseText(String text, String indentation) {
        return Arrays.stream(text.split("\n"))
                .map((s) -> indentation + s.strip() + "\n")
                .collect(Collectors.joining());
    }
}
