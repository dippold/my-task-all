<%-- 
    Document   : MenuInclude
    Created on : 17/05/2018, 11:31:34
    Author     : Fabio Tavares Dippold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- MenuInclude.jsp -->
<!-- FORM TO SIGNOUT -->
<form id="formSair" name="formSair" method="POST" action="mvc?class=LogOutCmd">
</form><!-- /FORM TO SIGNOUT -->

<!-- DIV MODAL SAIR -->
<div class="modal fade" id="sair-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalLabel">SAIR</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>                
            </div>
            <div class="modal-body">Deseja sair do sistema?</div>
            <div class="modal-footer">
                <button id="btnSair" type="button" class="btn btn-primary" onclick="javascript:$('#formSair').submit();">Sim</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
            </div>
        </div>
    </div>
</div><!-- /DIV MODAL SAIR-->

<!-- DIV MODAL ABOUT -->
<div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalLabel">Sobre o sistema</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                </span>&nbsp; Produto: My Task<br>
                </span>&nbsp; Versão: 2.0.1<br>
                </span>&nbsp; Release 2017/07/29<br>
                </span>&nbsp; Autor: Fábio Tavares Dippold<br>
                </span>&nbsp; <a href="mailto:dippold.br@gmail.com">dippold.br@gmail.com</a><br>
                </span>&nbsp; FTD BuilderForce Software Engineer<br>
                </span>&nbsp; Usuário: ${userName}<br>
                </span>&nbsp; Empresa: ${companyId}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div><!-- /DIV MODAL ABOUT-->

<!-- NAV BAR -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">

    <a class="navbar-brand" href="mvc?class=HomeCmd">
        <i class="fas fa-hands-helping"></i>&nbsp;${appname}
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">

            
            <!-- MENU DINÂMICO -->

            <c:forEach var="menu" items="${menus}">

                <!-- SUB-MENU ${menu.name} -->
                
                <li class="nav-item dropdown">                
                    <a class="nav-link dropdown-toggle" id="dropdown${menu.name}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="${menu.icon}"></i>&nbsp;${menu.name}&nbsp;
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown${menu.name}">

                        <c:forEach var="subMenu" items="${subMenus}">

                                <c:if test="${subMenu.menuId == menu.id}">

                                    <a class="dropdown-item" href="mvc?class=${subMenu.resource}&do=${subMenu.actionId}">
                                        <i class="${subMenu.icon}"></i>&nbsp;${subMenu.name}
                                    </a>

                                </c:if>

                        </c:forEach> 

                    </div>
                </li><!-- /SUB-MENU ${menu.name} --> 


            </c:forEach>            

            <!-- /MENU DINÂMICO -->


            <!-- SUB-MENU CONFIG -->
            <!--
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="dropdownConfig" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-cogs"></i>&nbsp;Config&nbsp;
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownConfig">

                    <a class="dropdown-item" href="mvc?class=ChangePasswdCmd&do=2">
                        <i class="fas fa-user-edit"></i>&nbsp;Mudar Senha
                    </a>

                    <c:if test="${ruleId == '1'}">
                        <a class="dropdown-item" href="mvc?class=ResetPasswdCmd&do=2">
                            <i class="fas fa-user-check"></i>&nbsp;Resetar Senhas
                        </a>
                    </c:if>                    

                    <c:if test="${ruleId == '1' || ruleId == '2'}">
                        <a class="dropdown-item" href="mvc?class=UserCmd&do=0">
                            <i class="fas fa-users-cog"></i>&nbsp;Usuários
                        </a>
                    </c:if>

                    <c:if test="${ruleId == '1'}">
                        <a class="dropdown-item" href="mvc?class=ConfigKeyCmd&do=0">
                            <i class="fas fa-key"></i>&nbsp;Chaves
                        </a>
                        <a class="dropdown-item" href="mvc?class=LogCmd&do=0">
                            <i class="fas fa-user-check"></i>&nbsp;Logs
                        </a>
                    </c:if>                    



                </div>
            </li>
            -->
            <!-- /SUB-MENU CONFIG -->

            <!-- SAIR OPTION -->
            <li class="nav-item">
                
                <!--
                <a id="linkAbout" href="#" class="dropdown-item" data-toggle="modal" data-target="#about-modal" title="INF. SOBRE O SISTEMA">
                    <i class="fas fa-chalkboard-teacher"></i></a>
                </a>
                -->
                
                <a id="linkSair" href="#" class="nav-link" data-toggle="modal" data-target="#sair-modal" title="SAIR">
                    <i class="fas fa-power-off"></i>&nbsp;Sair
                </a>                
            </li><!-- /SAIR OPTION -->           

            <!-- USER LOGIN OPTION -->
            <a class="navbar-brand" href="mvc?class=HomeCmd">
                &nbsp;&nbsp;&nbsp;<i class="fas fa-user-circle" title="Usuário: ${userName} / Empresa: ${companyId}"></i> 
            </a><!-- /USER LOGIN OPTION -->               

        </ul>

    </div>
</nav><!-- /NAV BAR -->
