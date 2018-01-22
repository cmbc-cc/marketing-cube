package stepdefinition;


import method.BaseTest;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import cucumber.api.PendingException;

import java.util.List;

public class MarketingCube2StepDefinitions implements BaseTest{
    @假如("^客户无资质$")
    public void 客户无资质() throws Throwable {
        String url = prefix + noQualify;
        navigationObj.navigateTo(url);
//      clickObj.click("id", "share_pop");
        progressObj.wait("10");
    }

    @假如("^客户有资质$")
    public void 客户有资质() throws Throwable {
        String url = prefix + noQualify;
        navigationObj.navigateTo(url);
//      clickObj.click("id", "share_pop");
        progressObj.wait("10");
    }

    @当("^访问活动 \"([^\"]*)\"$")
    public void 访问活动(String actyTitle) throws Throwable {
        activityObj.click_activity(actyTitle);
    }

    @那么("^兑换按钮置灰$")
    public void 兑换按钮置灰() throws Throwable {
        String dhText = assertionObj.getElementText("binding", "buttonName(item)");
        if (dhText.equals("查询资质信息")) {
            clickObj.click("binding", "buttonName(item)");
        }
        assertionObj.checkElementAttribute("binding", "class", "ng-binding btn_gray", "buttonName(item)", true);
    }

    @那么("^兑换按钮可用$")
    public void 兑换按钮可用() throws Throwable {
        String dhText = assertionObj.getElementText("binding", "buttonName(item)");
        if (dhText.equals("查询资质信息")) {
            clickObj.click("binding", "buttonName(item)");
        }
        assertionObj.checkElementAttribute("binding", "class", "ng-binding btn_dh", "buttonName(item)", true);
    }

    @那么("^展示话术 \"([^\"]*)\"$")
    public void 展示话术(String topTxt) throws Throwable {
        assertionObj.checkElementText("class", topTxt, "top_txt", true);
    }

    @当("^输入正确图片验证码$")
    public void 输入正确图片验证码() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @那么("^礼品可查看详情$")
    public void 礼品可查看详情(List<Gift> items) throws Throwable {
        String dhText = assertionObj.getElementText("binding", "buttonName(item)");
        if (dhText.equals("查询资质信息")) {
            clickObj.click("binding", "buttonName(item)");
        }
        for (Gift gift : items ) {
            activityObj.checkGiftButtonText("查看详情", gift.remark, true);
        }
    }

    @那么("^礼品可兑换$")
    public void 礼品可兑换(List<Gift> items) throws Throwable {
        String dhText = assertionObj.getElementText("binding", "buttonName(item)");
        if (dhText.equals("查询资质信息")) {
            clickObj.click("binding", "buttonName(item)");
        }
        for (Gift gift : items ) {
            activityObj.checkGiftButtonText("立即兑换", gift.remark, true);
        }
    }

    @当("^兑换礼品$")
    public void 兑换礼品(List<Gift> items) throws Throwable {
        for (Gift gift : items) {
            activityObj.click_gift(gift.remark);
        }
    }

    @那么("^弹窗展示话术 \"([^\"]*)\"$")
    public void 下单展示话术(String message) throws Throwable {
        assertionObj.checkElementText("binding",message, "orderMessage", true);
    }

    public static class Gift {
        public String title;
        public String remark;

        public Gift() {
            super();
        }
    }
}
