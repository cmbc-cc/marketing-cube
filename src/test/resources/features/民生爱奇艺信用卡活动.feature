# language: zh-CN
功能: 民生爱奇艺联名卡积分兑换特权活动

  场景大纲: 客户无资质
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/index.html?encryptStr=iNCCNqr5LAp/wnVtc4XBr7FzlLS1cS/PYZaxTNn/xRln8aYryzF2RRFwVYizQThV2Q8ORNZJSA25KmjxBYpXz6r2oHMPq9ljsXH6xwik55EhLQJxx98Yq6NG5J6ksBZZ0fKN0zfWWds3+zqUOrlomvVq955QdxUCyoEvgKc7BeI= "
    并且 I click on element having id "share_pop"
    那么 activity having title "<title>" should be present
    当 I click on activity having title "<title>"
#    那么 element having class "btn_dh" should have text as "查询资质信息"
#    当 I click on element having class "btn_dh"
    那么 element having class "top_txt" should have text as "<top_txt>"
    并且 element having class "btn_gray" should have text as "<btn_gray>"
    并且 gift having remark "<gift_remark>" should be present
    例子:
      | title | top_txt | btn_gray | gift_remark |
      | 民生爱奇艺联名卡积分兑换特权 | 很遗憾，您当前信用卡积分不足9900积分 | 立即兑换 | 无 |