<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>

	<h3>letter List</h3>
	<c:if test="${!empty loa}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">letter</th>
				<th width="120">I1</th>
				<th width="60">I2</th>
				<th width="60">SOUND</th>
			</tr>
			<c:forEach items="${loa}" var="l">
				<tr>
					<td>${l.id}</td>
					<td>${l.letter}</td>
					<td><img src="data:image/jpg;base64,${l.imgEnc64}"></td>
					<td><img src="data:image/jpg;base64,${l.img2Enc64}"></td>
					<td><audio id ="audio" controls preload="none">
							<source src="data:audio/mp3;base64,${l.soundEnc64}" type="audio/mpeg">
						</audio></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>