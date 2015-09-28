package weather;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import weather.sikuli.LotameCustData;
import weather.sikuli.SaveNotepad;
import weather.sikuli.SearchFor;
import weather.sikuli.Sequence;
import weather.sikuli.StartCharles;
import weather.sikuli.WfxCustData;
import weather.testcases.LotameValidation;
import weather.testcases.VerifyDMA;
import weather.testcases.VerifyLotame;
import weather.testcases.VerifyOrd;
import weather.testcases.VerifyPollenData;
import weather.testcases.VerifyRmid;
import weather.testcases.VerifyWfxFromDoc;
import weather.testcases.VerifyZip;
import weather.testcases.WfxDatavalidation;

public class NewTest {
    @BeforeTest
    public void CharlesStart() throws Exception {
	StartCharles sc = new StartCharles();
	sc.charles();

	DesiredCap dc = new DesiredCap();
	dc.dcap();

    }

    @Test(priority = 1)
    public void search_location() throws Exception {

	Searchlocation Sl = new Searchlocation();
	Sl.search();
	Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void Sequencetab() throws Exception {
	Sequence sq = new Sequence();
	sq.select_Sequence();
    }

    @Test(priority = 3)
    public void search_api() throws Exception {
	Thread.sleep(300);
	FirstScroll fScroll = new FirstScroll();
	fScroll.fScroll();
	Thread.sleep(500);
	SearchFor sapi = new SearchFor();
	sapi.searchapi();

    }

    @Test(priority = 4)
    public void SaveFile() throws Exception {
	SaveNotepad ee = new SaveNotepad();
	ee.notepad_save();

    }

    /*
     * @Test(priority=4) public void Scroll_1() throws Exception{ clearLogs
     * clogs= new clearLogs(); clogs.clear_logs(); Thread.sleep(300);
     * firstScroll fScroll = new firstScroll(); fScroll.fScroll();
     * 
     * }
     */

    @Test(priority = 5)
    public void Validate_ord() throws Exception {
	VerifyOrd val = new VerifyOrd();
	val.ord();
    }

    @Test(priority = 6)
    public void Validate_pln() throws Exception {
	VerifyPollenData Verify_plln = new VerifyPollenData();
	Verify_plln.plln();
    }

    @Test(priority = 7)
    public void Validate_Zip() throws Exception {
	VerifyZip Verify_Zip = new VerifyZip();
	Verify_Zip.verifyZip();
    }

    @Test(priority = 8)
    public void Validate_DMA() throws Exception {
	VerifyDMA Verifydma = new VerifyDMA();
	Verifydma.verifyDMA();
    }

    @Test(priority = 9)
    public void Validate_rmid() throws Exception {
	VerifyRmid Verifyrmid = new VerifyRmid();
	Verifyrmid.verifyrmid();
    }

    @Test(priority = 10)
    public void wfx_data() throws Exception {
	WfxCustData wfx_cust = new WfxCustData();
	wfx_cust.wfxdata();
    }

    /*@Test(priority = 11)
    public void WFX_verify() throws Exception {
	VerifyWfxFromDoc.wfx();

    }*/

    @Test(priority = 12)
    public void Lotamecustdata() throws Exception {
	LotameCustData ldata = new LotameCustData();
	ldata.Lotamedata();
    }

    @Test(priority = 13)
    public void LotameVerify() throws Exception {
	VerifyLotame vlotame = new VerifyLotame();
	vlotame.Lotame();

    }

    @Test(priority = 14)
    public void wfxverification() throws Exception {
	WfxDatavalidation wfx_ver = new WfxDatavalidation();
	wfx_ver.zcsvalidation();
	wfx_ver.nzcsvalidation();

    }

    @Test(priority = 15)
    public void Lotameverification() throws Exception {
	LotameValidation Lotame_ver = new LotameValidation();
	Lotame_ver.Lotame_validation();

    }

    /*
     * @Test(priority=10) public void Factual_data() throws Exception{
     * Factual_custdata factual = new Factual_custdata(); factual.Factualdata();
     * }
     */

    /*
     * @Test(priority=5) public void EnterAddress() throws Exception{
     * enter_Address ea = new enter_Address(); ea.enteraddress(); }
     */

    @AfterTest
    public void afterTest() {

    }

}
