package platform.common.base.api.request;

import java.io.Serializable;
import java.util.Date;

import platform.common.base.api.enums.DeleteFlag;

/**
 * 
 * @Title: BaseReq
 * @Description:
 * @author kangjin.zhao èμμ
 * @date 2019年7月9日
 */
public class BaseReq implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6109804952744305966L;

	private Date createDate;
	private String createBy;
	private Date lastUpdate;
	private String lastUpdateBy;
	private DeleteFlag deleteFlag;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(DeleteFlag deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
