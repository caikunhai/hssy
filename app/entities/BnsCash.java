/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/11/11 ��Ԫ at 11:01:58 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsCash</p>
 *
 * <p>Description: Domain Object describing a BnsCash entity</p>
 *
 */
@Entity (name="BnsCash")
@Table (name="bns_cash")
@NamedQueries({
	 @NamedQuery(name="BnsCash.findAll", query="SELECT bnscash FROM BnsCash bnscash")
	,@NamedQuery(name="BnsCash.findByCode", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.code = :code")
	,@NamedQuery(name="BnsCash.findByCodeContaining", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.code like :code")

	,@NamedQuery(name="BnsCash.findByMoney", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.money = :money")

	,@NamedQuery(name="BnsCash.findByType", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.type = :type")

	,@NamedQuery(name="BnsCash.findByUpdateTime", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.updateTime = :updateTime")

	,@NamedQuery(name="BnsCash.findByCheckedUser", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.checkedUser = :checkedUser")
	,@NamedQuery(name="BnsCash.findByCheckedUserContaining", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.checkedUser like :checkedUser")

	,@NamedQuery(name="BnsCash.findByCreatedUser", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.createdUser = :createdUser")
	,@NamedQuery(name="BnsCash.findByCreatedUserContaining", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.createdUser like :createdUser")

	,@NamedQuery(name="BnsCash.findByCreatedTime", query="SELECT bnscash FROM BnsCash bnscash WHERE bnscash.createdTime = :createdTime")

})

public class BnsCash implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_TYPE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsCash.findAll";
    public static final String FIND_BY_CODE = "BnsCash.findByCode";
    public static final String FIND_BY_CODE_CONTAINING ="BnsCash.findByCodeContaining";
    public static final String FIND_BY_MONEY = "BnsCash.findByMoney";
    public static final String FIND_BY_TYPE = "BnsCash.findByType";
    public static final String FIND_BY_UPDATETIME = "BnsCash.findByUpdateTime";
    public static final String FIND_BY_CHECKEDUSER = "BnsCash.findByCheckedUser";
    public static final String FIND_BY_CHECKEDUSER_CONTAINING ="BnsCash.findByCheckedUserContaining";
    public static final String FIND_BY_CREATEDUSER = "BnsCash.findByCreatedUser";
    public static final String FIND_BY_CREATEDUSER_CONTAINING ="BnsCash.findByCreatedUserContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsCash.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-code@
    @Column(name="code"  , length=30 , nullable=true , unique=false)
    private String code; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name="type"   , nullable=true , unique=false)
    private Integer type; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @update_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @update_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-update_time@
    @Column(name="update_time"   , nullable=true , unique=false)
    private Timestamp updateTime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @checked_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @checked_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-checked_user@
    @Column(name="checked_user"  , length=64 , nullable=true , unique=false)
    private String checkedUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_user@
    @Column(name="created_user"  , length=64 , nullable=true , unique=false)
    private String createdUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_time@
    @Column(name="created_time"   , nullable=true , unique=false)
    private Timestamp createdTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public BnsCash() {
    }

	/**
	* All field constructor 
	*/
    public BnsCash(
       String id,
       String code,
       java.math.BigDecimal money,
       Integer type,
       Timestamp updateTime,
       String checkedUser,
       String createdUser,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCode (code);
       setMoney (money);
       setType (type);
       setUpdateTime (updateTime);
       setCheckedUser (checkedUser);
       setCreatedUser (createdUser);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsCash flat() {
	   return new BnsCash(
          getId(),
          getCode(),
          getMoney(),
          getType(),
          getUpdateTime(),
          getCheckedUser(),
          getCreatedUser(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-code@
    public String getCode() {
        return code;
    }
	
    public void setCode (String code) {
        this.code =  code;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-money@
    public java.math.BigDecimal getMoney() {
        return money;
    }
	
    public void setMoney (java.math.BigDecimal money) {
        this.money =  money;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public Integer getType() {
        return type;
    }
	
    public void setType (Integer type) {
        this.type =  type;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-update_time@
    public Timestamp getUpdateTime() {
        return updateTime;
    }
	
    public void setUpdateTime (Timestamp updateTime) {
        this.updateTime =  updateTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-checked_user@
    public String getCheckedUser() {
        return checkedUser;
    }
	
    public void setCheckedUser (String checkedUser) {
        this.checkedUser =  checkedUser;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_user@
    public String getCreatedUser() {
        return createdUser;
    }
	
    public void setCreatedUser (String createdUser) {
        this.createdUser =  createdUser;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_cash@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (type==null) type=__DEFAULT_TYPE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_cash@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (type==null) type=__DEFAULT_TYPE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
