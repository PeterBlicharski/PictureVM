/* $Id: PnmStates.java,v 1.2 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.picture;

interface PnmStates {

    static final int
        start               = 0
        ,comment            = start + 1
	,magic              = comment + 1 
	,wid                = magic + 1
	,hei                = wid + 1
	,maxv               = hei + 1
	,ende               = maxv + 1;
}
