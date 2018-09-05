package org.ftd.mytask.web.cmds;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.educational.mytask.persistence.daos.ConfigKeyDAO;
import org.ftd.educational.mytask.persistence.daos.PasswdDAO;
import org.ftd.educational.mytask.persistence.daos.UserDAO;
import org.ftd.educational.mytask.persistence.entities.ConfigKey;
import org.ftd.educational.mytask.persistence.entities.Passwd;
import org.ftd.educational.mytask.persistence.entities.User;
import org.ftd.mytask.web.adapters.ButtonDefinition;
import org.ftd.mytask.web.adapters.FieldDefinition;
import org.ftd.mytask.web.adapters.FormDefinition;
import org.ftd.mytask.web.adapters.IdNameAdapter;
import org.ftd.mytask.web.mvc.abstracts.MVC;
import static org.ftd.mytask.web.mvc.abstracts.MVC.CMD_LOG_OUT;
import static org.ftd.mytask.web.mvc.abstracts.MVC.MSG_INVALID_ACTION;
import static org.ftd.mytask.web.mvc.abstracts.MVC.MVC_ACTION_BUILD_UPD_MODEL;
import static org.ftd.mytask.web.mvc.abstracts.MVC.MVC_ACTION_UPDATE;
import static org.ftd.mytask.web.mvc.abstracts.MVC.PARAMETER_NAME_ACTION;
import static org.ftd.mytask.web.mvc.abstracts.MVC.PARAMETER_NAME_CMD;
import static org.ftd.mytask.web.mvc.abstracts.MVC.PARAMETER_NAME_MESSAGE;
import static org.ftd.mytask.web.mvc.abstracts.MVC.URL_MVC_SERVICE;
import static org.ftd.mytask.web.mvc.abstracts.MVC.readParameter;
import org.ftd.mytask.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0 - 2018-09-05
 *
 */
public class ResetPasswdCmd implements ICmd {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final String action = readParameter(request, PARAMETER_NAME_ACTION, "");
        final String nextAction;

        switch (action) {
            case MVC_ACTION_BUILD_UPD_MODEL:
                nextAction = buildUpdateModel(request, response);
                break;
            case MVC_ACTION_UPDATE:
                nextAction = doUpdate(request, response);
                break;
            default:
                request.setAttribute(PARAMETER_NAME_MESSAGE, MSG_INVALID_ACTION);
                nextAction = URL_MVC_SERVICE
                        + "?"
                        + PARAMETER_NAME_CMD
                        + "="
                        + CMD_LOG_OUT
                        + "&"
                        + PARAMETER_NAME_MESSAGE
                        + "="
                        + MSG_INVALID_ACTION;
        }

        MVC.setDefaultAttributes(request);

        return nextAction;

    }

    public String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("title", "Reset de senhas");

        final String formTitle = "Reset de senhas ";

        final String urlToGo = MVC.URL_MVC_SERVICE
                + "?" + MVC.PARAMETER_NAME_CMD
                + "=" + this.getClass().getSimpleName()
                + "&" + MVC.PARAMETER_NAME_ACTION
                + "=" + MVC.MVC_ACTION_UPDATE;

        final String urlToGoBack = MVC.URL_MVC_SERVICE
                + "?" + MVC.PARAMETER_NAME_CMD
                + "=" + MVC.CMD_HOME;

        List<IdNameAdapter> users = this.findAllUser(request);

        /*  HTML FIELD DEFINITIONS ... */
        final List<FieldDefinition> fields = new ArrayList<>();
        fields.add(new FieldDefinition(6, FieldDefinition.TYPE_COMBO, "userIdInput", "Usuário", "", users, "Selecione um grupo!", "required", "", 0, 0));

        final List<ButtonDefinition> buttons = new ArrayList<>();
        buttons.add(new ButtonDefinition(ButtonDefinition.TYPE_SUBMIT, "btnSubmit", "Salvar", "btn btn-outline-primary", ""));
        buttons.add(new ButtonDefinition(ButtonDefinition.TYPE_SIMPLE, "btnCancel", "Cancelar", "btn btn-outline-success", urlToGoBack));

        /* HTML FORM DEFINITIONS ...*/
        final FormDefinition form = new FormDefinition(formTitle, "formUpdate", "POST", urlToGo, fields, buttons);

        request.setAttribute("oForm", form);

        return "WEB-INF/views/__OneColumnFormEngine.jsp";
    }

    public String doUpdate(HttpServletRequest request, HttpServletResponse response) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(MVC.PERSISTENCE_UNIT);
        Long id = Long.parseLong(MVC.readParameter(request, "userIdInput"));

        /* BUSCANDO O USUÁRIO */
        UserDAO userDAO = new UserDAO(factory);
        User user = userDAO.find(id);

        try {
            /* BUSCANDO A SENHA PADRÃO */
            ConfigKeyDAO cfgDAO = new ConfigKeyDAO(factory);
            ConfigKey key = cfgDAO.findConfigKey(MVC.getUserCompanySessionId(request), "passwd.default");
            
            /* CADASTRANDO A SENHA PADRÃO */
            PasswdDAO passDAO = new PasswdDAO(factory);
            Passwd passwd = passDAO.findByUser(id);
            passwd.setName(key.getKeyValue());
            passDAO.edit(passwd);
            request.setAttribute("msg", MVC.MSG_RESET_PASSWD_SUCESS + user.getName());
        } catch (Exception ex) {
            request.setAttribute("msg", MVC.MSG_RESET_PASSWD_FAILURE + user.getName());
        }

        return MVC.URL_MVC_SERVICE
                + "?" + MVC.PARAMETER_NAME_CMD
                + "=" + this.getClass().getSimpleName()
                + "&" + MVC.PARAMETER_NAME_ACTION
                + "=" + MVC.MVC_ACTION_BUILD_UPD_MODEL;
    }

    private List<IdNameAdapter> findAllUser(HttpServletRequest request) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(MVC.PERSISTENCE_UNIT);
        UserDAO dao = new UserDAO(factory);
        List<User> users = dao.findAllByCompany(MVC.getUserCompanySessionId(request));
        List<IdNameAdapter> datasource = new ArrayList<>();

        users.forEach((o) -> {
            datasource.add(new IdNameAdapter(o.getId(), o.getName()));
        });

        return datasource;
    }

}
