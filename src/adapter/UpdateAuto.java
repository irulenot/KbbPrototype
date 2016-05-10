package adapter;

/**
 *  Anthony Bilic
 */
public interface UpdateAuto {

    void updateOptionSetName(String modelName, String optionSetName, String newName);

    void updateOptionPrice(String modelName, String optionName, String option, double newPrice);

}
