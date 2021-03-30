/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Tests all test modules
 */

package src;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestAttributeT.class,	
   TestLOsT.class,
   TestCourseT.class,
   TestProgramT.class
})

public class AllTests
{
}
