package filterUseCases;

public class FilterByNameRequestModel {

    final private String name;

    public FilterByNameRequestModel(String name){ this.name = name; }

    public String getName(){ return this.name; }


}
