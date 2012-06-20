class Picture {

    private int width;
    private int height;
    private int pixel[];

    public forAllPixel (PicInstr picCom) {
	for (int i = 0; i < width*height; ++i ) {
	    picCom.exec();
	}
    }




}
