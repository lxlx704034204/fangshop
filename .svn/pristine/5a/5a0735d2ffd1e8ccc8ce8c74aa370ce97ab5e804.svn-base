package com.fang.fangshop.core.system.been;
import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.common.PageModel;

@RedisCache
public class Menu extends PageModel{
	@RedisFieldNotCache
	private static final String className = "menu";
	@RedisFieldNotCache
	private static final String primaryKey = "id";

	private Integer id;
	/** t_menu.pid */
    private Integer pid;
    public Integer ordernum;

    /** t_menu.url */
    private String url;

    /** 111 */
    private String name;


    /** t_menu.type */
    private String type;

    private boolean open = false;// 是否展开
    private boolean checked;// true:勾选

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
	public String toString() {
		return "Menu [pid=" + pid + ", url=" + url + ", name=" + name + ", ordernum=" + ordernum + ", type=" + type
				+ "]";
	}

	public Menu(Integer id, Integer pid, String url, String name, Integer ordernum, String type) {
		super();
		this.id = id;
		this.pid = pid;
		this.url = url;
		this.name = name;
		this.ordernum = ordernum;
		this.type = type;
	}

	public Menu() {
		super();
	}
}