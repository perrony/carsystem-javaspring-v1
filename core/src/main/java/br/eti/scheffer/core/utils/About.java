package br.eti.scheffer.core.utils;

public class About {

    public static String getAbout(String modulo) {
        return  "<!DOCTYPE html>" +
                "<html lang=\"pt-BR\">" +
                "  <head>" +
                "    <meta charset='utf-8'>" +
                "    <title>Módulo de "+modulo+"</title>" +
                "	<style>" +
                "		body {"+
                "			background-color: #FFFFFF;"+
                "		}"+
                "		.confirma {"+
                "			background-color: #D4AC0D;"+
                "			padding: 15px;"+
                "			margin: 20px auto;"+
                "			text-align: center;"+
                "			width: 80%;"+
                "			border-radius: 10px;"+
                "		}"+
                "		.text-body {"+
                "			background-color: #D6DBDF;"+
                "			padding: 15px;"+
                "			margin: 20px auto;"+
                "			width: 80%;"+
                "			border-radius: 10px;"+
                "			text-align: center;"+
                "    }"+
                "	</style>"+
                "  </head>"+
                "<body>"+
                "	<div class='confirma'>"+
                "		<h1>Bem-vindo!</h1>"+
                "	</div>"+
                "	<div class='text-body'>"+
                "		<h2>Módulo de "+modulo+"</h2>"+
                "		<p>Em caso de dúvidas, entrar em contato com o administrador do sistema!</p>"+
                "	</div>"+
                " </body>"+
                "</html>";



    }
}
