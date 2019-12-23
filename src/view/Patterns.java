package view;

import java.util.regex.Pattern;

public class Patterns {
    //This class maybe will be merged in input system. But as of now, it is just a Place for View.Patterns;
    static Pattern[] majorLoginPatterns = new Pattern[]{
            Pattern.compile("^(?i)leaderboard\\s*$"),
            Pattern.compile("^(?i)create account\\s*$"),
            Pattern.compile("^(?i)login\\s*$"),
    };
    static Pattern[] loginPattern = new Pattern[]{
            Pattern.compile("^(?i)(\\S+) (\\S+)\\s*$"),
    };
    static Pattern[] shopPatterns = new Pattern[]{
            Pattern.compile("^(?i)money\\s*$"),
            Pattern.compile("^(?i)show shop\\s*$"),
            Pattern.compile("^(?i)show collection\\s*$"),
            Pattern.compile("^(?i)buy (\\S+)\\s*$"),
    };

}