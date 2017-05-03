package ad.servlets;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;

public class DaoContainerManager implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent event) {
        DaoContainer container = DaoContainerFactory.create();
        event.getServletRequest().setAttribute("dao-container", container);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        DaoContainer container = (DaoContainer)event.getServletRequest().getAttribute("dao-container");
        container.close();
    }
}
