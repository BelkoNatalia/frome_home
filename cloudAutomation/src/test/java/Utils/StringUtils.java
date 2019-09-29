package Utils;

public class StringUtils {
    public static String formatEstimatedCost(String estimatedCostByPage){
        String[] estimatedCostArray = estimatedCostByPage.split(":");
        String expectedEstimatedCostValue = estimatedCostArray[1].replaceAll("per 1 month", "").trim();
        return expectedEstimatedCostValue;
    }
}
