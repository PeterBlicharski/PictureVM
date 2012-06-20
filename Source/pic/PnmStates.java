/* $Id: PnmStates.java,v 1.1 2002/12/02 23:22:55 ii3839 Exp $ */

interface PnmStates {

    static final int
        start               = 0
        ,comment            = start + 1
	,magic              = comment + 1 
	,wid                = magic + 1
	,hei                = wid + 1
	,maxv               = hei + 1
	,end                = maxv + 1;
}
