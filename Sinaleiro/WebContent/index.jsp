<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/jquery.js"></script>
		
		<script src="js/microlink.js"></script>
		<script src="js/uniqueurl.js"></script>
		<script src="js/progressindicator.js"></script>
		<script src="js/livesearch.js"></script>
		
		<title>Insert title here</title>
	</head>
	<body>
		<div id="title"><h1>SInAU</h1></div>
		<div id="menu">
			<ul>
				<li onClick="microlink('aluno', 'result');">Alunos</li>
				<li onClick="microlink('curso', 'result');">Cursos</li>
				<li onClick="microlink('departamento', 'result');">Departamentos</li>
				<li onClick="microlink('professor', 'result');">Professores</li>
			</ul>
		</div>
		
		<div id="content">
			<div id="search">
				<form onSubmit="return false;">
					Buscar: <input type="text" id="search_input" name="search" onfocus="livesearch_start(this)" onblur="livesearch_stop()">
					<input type="submit" value="Buscar" onclick="livesearch(search.value)">
				</form>
			</div>
			
			<div id="result">nenhum resultado encontrado.</div>
		</div>
		<br class="clear" />
		<div id="progress" class="carregandoShow">Carregando</div>
	</body>
</html>