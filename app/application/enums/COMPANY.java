package application.enums;

/**
 * Created by pkonwar on 5/20/2016.
 */
public enum COMPANY {
    FLIPKART("FLIPKART"),
    AMAZON("AMAZON"),
    SNAPDEAL("SNAPDEAL"),
    JABONG("JABONG");

    String companyName;

    private COMPANY(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
