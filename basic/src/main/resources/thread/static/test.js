function pifLoginAdminUser()
{
    //拼接请求URL 包括http的 ip  port  name
    var uRL = ProjectSuite.Variables.PROTOCOL + ProjectSuite.Variables.DOMAIN + ProjectSuite.Variables.Application
    //如果浏览器打开的就先关了
    L_Close_Browser.closeBrowser();
    //浏览器指向到你们这个页面
    Browsers.Item(ProjectSuite.Variables.whatBrowser).Run(uRL);
    //这个是应该打开系统默认浏览器到这个页面吧
    var pifLoginPage = Sys.Browser(ProjectSuite.Variables.whatBrowser).Page(uRL + "/Login.aspx*")
    var pifDmn = pifLoginPage.Form("aspnetForm").FindChild("idStr","lbDomain",9)
    //Check to see if the domain dropdown exists and select none for this script.
    if (pifDmn.Exists == true){
        //Enter login credentials   
        pifLoginPage.Form("aspnetForm").FindChild("idStr","txtUserName",7).SetText(ProjectSuite.Variables.SCEAdmUsr);
        pifLoginPage.Form("aspnetForm").FindChild("idStr","txtPassword",7).SetText(ProjectSuite.Variables.SCEAdmPwd);
        pifDmn.ClickItem("(none)");
        pifLoginPage.Form("aspnetForm").FindChild("idStr","lnkLogin",9).Click();
    }
    else{
        Log.Warning("Hmm... there was no domain selection.  That's weird, right?");
        //Enter login credentials 
        pifLoginPage.Form("aspnetForm").FindChild("idStr","txtUserName",7).SetText(ProjectSuite.Variables.SCEAdmUsr);
        pifLoginPage.Form("aspnetForm").FindChild("idStr","txtPassword",7).SetText(ProjectSuite.Variables.SCEAdmPwd);
        //Login
        pifLoginPage.Form("aspnetForm").FindChild("idStr","lnkLogin",9).Click();
    }
    //confirm login
    delay(2000);
    var homePage = Sys.Browser(ProjectSuite.Variables.whatBrowser).WaitPage(uRL + "/MainMenu.aspx*",10000);
    if (homePage.Exists == true){
        Log.Message("User logged in to SWCE successfully!");
    }else{
        Runner.Halt("User login was unsuccessful!");
    }
}