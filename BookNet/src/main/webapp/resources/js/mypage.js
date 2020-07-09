$(document).ready(function () {
  $(".w3-button").click(function () {
    var ckfal = $(this).next().val();
    var pid = $(this).prev().val();

    $.ajax({
      url: "/cls/mypage/fal.cls",
      type: "POST",
      dataType: "text",
      data: {
        'ckfal': ckfal,
        'pid': pid
      },
      success: function (data) {
        if (data == 'Y') {
          $("#fal").html("팔로우중");
          $("#ckfal").val("Y");
        } else {
          $("#fal").html("팔로우하기");
          $("#ckfal").val("N");
        }
      },
      error: function (request, status, error) {
        alert(
          "code = " +
            request.status +
            " message = " +
            request.responseText +
            " error = " +
            error
        );
      },
    });
  });
});
