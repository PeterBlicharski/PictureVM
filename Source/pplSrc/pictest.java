
package ppl;

import ppl.Executable;

public class pictest extends Executable {
    public pictest() {
        super(new Instr []
	    {    loads("./lena.pgm")
		,svc(load)
//	        ,loads("./lena2.pgm")
//		,svc(load)
//		,loadf((float)3.0)
//	    	,loadi((int)2)
//	    	,loadi((int)1)
//		,svc(load)
//		,compute(invert)
//	    	,loadi((int)301)
//	    	,loadi((int)500)
//		,compute(resize)
//	    	,loadi((int))
//	    	,loadi((int))
//	    	,loadi((int)60)
//	    	,loadi((int)60)
		,compute(black)
		,loads("./resize_test.pgm")
		,svc(store)
	    }
	      , 2
	    );
    }
}
