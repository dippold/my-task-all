package org.ftd.educational.utils.json.results;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.1 - 2018-06-20
 *
 */
public class DatagridResult extends SimpleResult {
    
    private int page = 1;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}
