# language: zh-CN
功能: 营销魔方

  场景: 客户无资质
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/index.html?encryptStr=iNCCNqr5LAp/wnVtc4XBr7FzlLS1cS/PYZaxTNn/xRln8aYryzF2RRFwVYizQThV2Q8ORNZJSA25KmjxBYpXz6r2oHMPq9ljsXH6xwik55EhLQJxx98Yq6NG5J6ksBZZ0fKN0zfWWds3+zqUOrlomvVq955QdxUCyoEvgKc7BeI="
    并且 I click on element having id "share_pop"
    那么 activity having title "民生爱奇艺联名卡 首刷专享特权" should be present
    并且 activity having title "民生白条联名卡 五星级自助餐二免一畅享" should be present
    当 I click on activity having title "嗨购11.11"
    那么 element having class "top_txt" should have text as "很遗憾，您暂时没有嗨购双11礼券的资质"
    并且 gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should be present
    并且 gift having remark "进入大众点评APP订座电影票时使用。" should be present
    并且 gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should have button as "立即兑换"
    并且 button as "立即兑换" of gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should be disabled

  场景: 客户进行活动兑换
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/index.html?encryptStr=iNCCNqr5LAp/wnVtc4XBr7FzlLS1cS/PYZaxTNn/xRln8aYryzF2RRFwVYizQThV2Q8ORNZJSA25KmjxBYpXz6r2oHMPq9ljsXH6xwik55EhLQJxx98Yq6NG5J6ksBZZ0fKN0zfWWds3+zqUOrlomvVq955QdxUCyoEvgKc7BeI="
    并且 I click on element having id "share_pop"
    那么 activity having title "同道大叔星座卡独家伴手礼" should be present
    当 I click on activity having title "同道大叔星座卡独家伴手礼"
    #    那么 element having class "btn_dh" should have text as "查询资质信息"
    #    当 I click on element having class "btn_dh"
    那么 element having class "top_txt" should have text as "恭喜您获得同道星座伴手礼"
    并且 gift having remark "该项礼品仅可兑换一次，且不可与其他三项礼品同时选择" should be present
    并且 button as "立即兑换" of gift having remark "该项礼品仅可兑换一次，且不可与其他三项礼品同时选择" should be enabled
    当 I click on gift having remark "该项礼品仅可兑换一次，且不可与其他三项礼品同时选择"
    那么 element having class "btn_card" should have text as "确认兑换"
    当 I enter "test" into input field having id "phoneMsg"
    并且 I click on element having class "btn_card"
    那么 element having binding "orderMessage" should have text as "参与次数已满"
    并且 element having class "ylw_btn" should have text as "返 回"
    当 I click on element having class "ylw_btn"
    那么 element having class "btn_card" should have text as "确认兑换"