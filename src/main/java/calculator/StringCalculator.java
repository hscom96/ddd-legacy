package calculator;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\n";
    private static final String BLANK_CUSTOM_DELIMITER = "";

    public int add(final String text) {
        if (!StringUtils.hasText(text)) {
            return 0;
        }

        if (isNumber(text) && Integer.parseInt(text) > 0) {
            return Integer.parseInt(text);
        }

        String customDelimiter = getCustomDelimiter(text);
        String customRemovedText = removeCustomDelimiter(text);

        List<String> nums = Stream.of(customRemovedText.split(",|:|" + customDelimiter))
                                  .filter(StringUtils::hasText)
                                  .collect(Collectors.toList());
        validateNumFormat(nums);
        return nums.stream()
                   .mapToInt(Integer::parseInt)
                   .sum();
    }

    private void validateNumFormat(final List<String> nums) {
        for (String num : nums) {
            if (!isNumber(num) || Integer.parseInt(num) < 0) {
                throw new IllegalArgumentException("숫자는 숫자 이외의 값 또는 음수를 전달할 수 없습니다.");
            }
        }
    }

    private String getCustomDelimiter(String text) {
        if (!text.startsWith(CUSTOM_DELIMITER_START)) {
            return BLANK_CUSTOM_DELIMITER;
        }
        int endDelimiterIdx = text.indexOf(CUSTOM_DELIMITER_END);
        return text.substring(CUSTOM_DELIMITER_START.length(), endDelimiterIdx);
    }

    private String removeCustomDelimiter(String text) {
        if (!text.startsWith(CUSTOM_DELIMITER_START)) {
            return text;
        }
        int endDelimiterIdx = text.indexOf(CUSTOM_DELIMITER_END);
        return text.substring(endDelimiterIdx + 1);
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
