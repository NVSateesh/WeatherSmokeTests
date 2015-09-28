package weather.testcases;

public class WfxDatavalidation {

    public void zcsvalidation() throws Exception {
	WfxRead wfxread = new WfxRead();
	wfxread.wfxValidation("zcs");

    }

    public void nzcsvalidation() throws Exception {
	WfxRead wfxread = new WfxRead();
	wfxread.wfxValidation("nzcs");
    }

}
