# language: zh-CN
功能: Marketing cube

  场景大纲: 客户已经兑换过了
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/index.html?encryptStr=iNCCNqr5LAp/wnVtc4XBr7FzlLS1cS/PYZaxTNn/xRln8aYryzF2RRFwVYizQThV2Q8ORNZJSA25KmjxBYpXz6r2oHMPq9ljsXH6xwik55EhLQJxx98Yq6NG5J6ksBZZ0fKN0zfWWds3+zqUOrlomvVq955QdxUCyoEvgKc7BeI="
    那么 activity having title "<title>" should be present
    当 I click on activity having title "<title>"
#    那么 element having class "btn_dh" should have text as "查询资质信息"
#    当 I click on element having class "btn_dh"
    那么 element having class "top_txt" should have text as "<top_txt>"
    并且 element having class "btn_dh" should have text as "立即兑换"
    并且 gift having remark "<gift_remark>" should be present
    当 I click on gift having remark "<gift_remark>"
    那么 element having class "btn_card" should have text as "确认兑换"
    并且 element having class "btn_card" should have attribute "class" with value "btn_card disable ng-scope"
    并且 element having binding "timeFormat" should have text as "<timeFormat>"
    例子:
      | title | top_txt | gift_remark | timeFormat |
      | 民生梵高主题信用卡 | 恭喜您获得民生梵高主题卡首刷礼 | 礼品限量6000份，先领先得。 | 您已经兑换过啦 |
