public class DatatableStepDef {
WebDriver driver;
WebDriverWait wait;

@Given("User is completes the requirement")
public void completereq() {
    System.out.println("Given activity completed");
}

@When("^User enters following username and password")
public void user_enters_and(DataTable credemtials) {
    List<List<String>> creds = credentials.asLists();
    for(List<String> cred : creds){
        for(String credential : cred){
            System.out.println(credential);
        }
    }
   
}

