//import org.jglue.cdiunit.ActivatedAlternatives;
//import org.jglue.cdiunit.CdiRunner;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//
///**
// * Created by jsska on 10.04.2014.
// */
//@RunWith(CdiRunner.class)
//@ActivatedAlternatives(value = {GreeterImpl.class, GreeterVersion2Impl.class})
//public class GreeterTest {
//
//
//    private Greeter greeterV1;
//
//    @Inject
//    @Named("greeterv2")
//    private Greeter greeterV2;
//
//    @Inject
//    @Named("greeterv2")
//    GreeterV2 greeterInterfaceV2;
//
//    @Inject
//    void setGreeterV1(@Named("greeterv1") Greeter greeterV1){
//        this.greeterV1 = greeterV1;
//    }
//
//
//    @Test
//    public void testGetGreeterv1(){
//        //Verfiy instance type
//        assertTrue(GreeterImpl.class.isAssignableFrom(greeterV1.getClass()));
//        assertFalse(GreeterVersion2Impl.class.isAssignableFrom(greeterV1.getClass()));
//
//        assertEquals("Hello from Guice, John Doe. Greeter v1", greeterV1.getGreeting("John Doe").getMessage());
//    }
//
//    @Test
//    public void testGetGreeterV2(){
//        //Verify instance type
//        assertTrue(GreeterVersion2Impl.class.isAssignableFrom(greeterV2.getClass()));
//        assertFalse(GreeterImpl.class.isAssignableFrom(greeterV2.getClass()));
//
//        assertEquals("Hello from Guice, John Doe. Greeter v2", greeterV2.getGreeting("John Doe").getMessage());
//    }
//
//    @Test
//    public void testGetGreeterInterfaceV2(){
//        //Verify instance type
//        assertTrue(GreeterVersion2Impl.class.isAssignableFrom(greeterInterfaceV2.getClass()));
//        assertFalse(GreeterImpl.class.isAssignableFrom(greeterInterfaceV2.getClass()));
//
//        assertEquals("Hello from Guice, John Doe. Greeter v2", greeterInterfaceV2.getGreeting("John Doe").getMessage());
//        assertEquals("Hello from Guice, John Doe. Greeter v2", greeterInterfaceV2.getGreeting("John", "Doe").getMessage());
//
//    }
//
//
//}
