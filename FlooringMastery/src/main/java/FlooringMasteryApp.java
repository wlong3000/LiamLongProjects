

import com.sg.flooringmastery.ops.FlooringMasteryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class FlooringMasteryApp {
    public static void main(String[] args) {
            ApplicationContext ctx = new
                    ClassPathXmlApplicationContext("applicationContext.xml");
            
            FlooringMasteryController controller = (FlooringMasteryController) 
                    ctx.getBean("flooringMasteryControllerFileIO");
            //FlooringMasteryController controller = (FlooringMasteryController)
                //ctx.getBean("flooringMasteryControllerInMem");
            
            controller.run();
    }

}
