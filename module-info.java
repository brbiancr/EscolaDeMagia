module escola_de_magia{
	requires java.persistence;
	requires javafx.fxml;
	requires javafx.controls;
	requires org.hibernate.orm.core; // Módulo principal do Hibernate ORM
    requires java.sql; // Módulo que contém as classes JDBC, incluindo SQLException
    requires java.transaction; // Módulo que contém as classes de transação Java

	opens core;
	opens infra;
	opens managers;
	opens model;
	opens utilitarios;
	opens view;
	opens view.administrador;
	opens view.aluno;
	opens view.disciplina;
	opens view.professor;
}