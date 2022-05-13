<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題5(発展)</title>
<style>
body {
    border: solid 2px #000080;
    padding: 5px;
}

.result {
    background: #fffacd;
    display: inline-block;
    margin: 5px;
    padding: 10px;
}

.info {
  border: solid 2px #4682b4;
  border-radius: 20px;
  width: 260px;
  margin: 5px;
  padding: 10px;
}

.info_border0 {
  border-radius: 20px;
  width: 260px;
  margin: 5px;
  padding: 10px;
}

.info label {
    display: inline-block;
    width: 80px;
    text-align: right;
}

.width-50 {
    width: 50px;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題5(発展)</h1>

  <c:if test="${not empty result}">
    <div class="result">
      <p>${result}</p>
    </div>
  </c:if>

  <h2>現在の登録情報</h2>
  <div class="info">
    <label>名前：</label> ${latestCar.getCarName()}<br>
    <label>車体の色：</label> ${latestCar.getBodyColor()} <br>
    <label>最高速度：</label> ${latestCar.getMaxSpeed()} <br>
    <label>現在速度：</label> ${latestCar.getSpeed()} <br>
  </div>

  <h2>変更履歴</h2>
  <div class="info">
    <table border="1">
      <tr>
        <th>車体の色</th>
        <th>現在速度</th>
      </tr>


      <!-- c:forEachについて
           javaの拡張for文にあたるものである
           items属性に配列やコレクションを指定する
           var属性に配列などから取り出した値を保存する変数名を指定する(型の指定は不要)
           ここでは、セッションに保存した変更履歴情報(ArrayList型)の
           値(Carオブジェクト)を取り出し、
           そのオブジェクトのゲッターメソッドを呼び、
           車体の色、現在速度を表示する
           ※テキストの補足説明を参照してください
      -->

      <!-- todo:
           下記の<tr>～</tr>タグ部分の4行をc:forEachタグで囲み、
           登録されている履歴の数だけ、その4行が繰り返し表示されるようにする
           <td>タグで囲まれている部分を修正し、登録されている
           履歴の情報(車体の色と現在速度)を表示する

      -->

	  <c:forEach var="car" items="${historyList}">
        <tr>
          <td>${car.getBodyColor()}</td>
          <td>${car.getSpeed()}</td>
        </tr>
      </c:forEach>

  </table>
  </div>

  <h2>変更</h2>

  <form action="updateServlet" method="post">
    <div class="info">
      <label>車体の色：</label> <input type="text" class="width-50" name="bodyColor" value="${car.getBodyColor()}">
      <br>
      <label>現在速度：</label> <input type="number" class="width-50" name="speed" value="${car.getSpeed()}">
      <br>
      <button type="submit" name="btn" value="update">変更</button> <br>
    </div>
    <div class="info_border0">
      <button type="submit" name="btn" value="back">最初に戻る</button>
    </div>
  </form>

</body>
</html>