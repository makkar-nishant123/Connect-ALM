package ALM_Test.ALM_Testa;

import com.mercury.qualitycenter.otaclient.ClassFactory;
import com.mercury.qualitycenter.otaclient.IBaseFactory;
import com.mercury.qualitycenter.otaclient.IList;
import com.mercury.qualitycenter.otaclient.ITDConnection;
import com.mercury.qualitycenter.otaclient.ITSTest;
import com.mercury.qualitycenter.otaclient.ITestSet;
import com.mercury.qualitycenter.otaclient.ITestSetFolder;
import com.mercury.qualitycenter.otaclient.ITestSetTreeManager;

import com4j.Com4jObject;




/**
 * Hello world!
 *
 */
public class App 
{
private static String url = "";
private static String domain = "";
private static String project = "";
private static String username = "";
private static String password = "";
private static String testsetfolder = "";
private static String testset = "";

	
	public static void main(String[] args) {
		

	   ITDConnection connection=null;
		
       
      
         
          	//QC Connection
          	connection = ClassFactory.createTDConnection();
          	
			connection.initConnectionEx(url);
          
          	connection.initConnectionEx(url);
          	connection.connectProjectEx(domain, project, username, password);
          
          //To get the Test Set folder in Test Lab        
          ITestSetTreeManager objTestSetTreeManager = (connection.testSetTreeManager()).queryInterface(ITestSetTreeManager.class);
          ITestSetFolder objTestSetFolder =(objTestSetTreeManager.nodeByPath(testsetfolder )).queryInterface(ITestSetFolder.class);
                  
          IList tsTestList = objTestSetFolder.findTestSets(null, true, null);
                  
          for (int i=1;i<=tsTestList.count();i++) 
          {
              Com4jObject comObj = (Com4jObject) tsTestList.item(i);
              ITestSet tst = comObj.queryInterface(ITestSet.class); 
              
              if(tst.name().equalsIgnoreCase(testset )){
                          
                  IBaseFactory testFactory = tst.tsTestFactory().queryInterface(IBaseFactory.class);
            
                  IList testInstances = testFactory.newList("");
                  
                  //To get Test Case ID instances
                  for (Com4jObject testInstanceObj : testInstances)
                  {  
                      ITSTest testInstance = testInstanceObj.queryInterface(ITSTest.class);  
                      
                      //System.out.println("Current Looping Test ID: " + testInstance.testId());
                      
                      String continue_flag = "no";
                      
                      // GET CONFIGURATION ID from the Database
	                    // Added for TestID-ConfigID input (if needed)
                     
	                       String tc_testcycle_id = testInstance.id().toString();
	                       System.out.println("Test Instance ID: " + tc_testcycle_id);
	               		
	                       
              	}
              }
          }
	}
}