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
	* - time      : 2016/11/15 ��Ԫ at 20:16:30 CST
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
 * <p>Title: BnsUser</p>
 *
 * <p>Description: Domain Object describing a BnsUser entity</p>
 *
 */
@Entity (name="BnsUser")
@Table (name="bns_user")
@NamedQueries({
	 @NamedQuery(name="BnsUser.findAll", query="SELECT bnsuser FROM BnsUser bnsuser")
	,@NamedQuery(name="BnsUser.findByCompany", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.company = :company")
	,@NamedQuery(name="BnsUser.findByCompanyContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.company like :company")

	,@NamedQuery(name="BnsUser.findByUsername", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.username = :username")
	,@NamedQuery(name="BnsUser.findByUsernameContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.username like :username")

	,@NamedQuery(name="BnsUser.findByPassword", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.password = :password")
	,@NamedQuery(name="BnsUser.findByPasswordContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.password like :password")

	,@NamedQuery(name="BnsUser.findBySecret", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.secret = :secret")
	,@NamedQuery(name="BnsUser.findBySecretContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.secret like :secret")

	,@NamedQuery(name="BnsUser.findByRole", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.role = :role")

	,@NamedQuery(name="BnsUser.findByToken", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.token = :token")
	,@NamedQuery(name="BnsUser.findByTokenContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.token like :token")

	,@NamedQuery(name="BnsUser.findByLoginIp", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.loginIp = :loginIp")
	,@NamedQuery(name="BnsUser.findByLoginIpContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.loginIp like :loginIp")

	,@NamedQuery(name="BnsUser.findByLoginTime", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.loginTime = :loginTime")

	,@NamedQuery(name="BnsUser.findByState", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.state = :state")

	,@NamedQuery(name="BnsUser.findByRemark", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.remark = :remark")
	,@NamedQuery(name="BnsUser.findByRemarkContaining", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.remark like :remark")

	,@NamedQuery(name="BnsUser.findByCreatedTime", query="SELECT bnsuser FROM BnsUser bnsuser WHERE bnsuser.createdTime = :createdTime")

})

public class BnsUser implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_ROLE = Integer.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsUser.findAll";
    public static final String FIND_BY_COMPANY = "BnsUser.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsUser.findByCompanyContaining";
    public static final String FIND_BY_USERNAME = "BnsUser.findByUsername";
    public static final String FIND_BY_USERNAME_CONTAINING ="BnsUser.findByUsernameContaining";
    public static final String FIND_BY_PASSWORD = "BnsUser.findByPassword";
    public static final String FIND_BY_PASSWORD_CONTAINING ="BnsUser.findByPasswordContaining";
    public static final String FIND_BY_SECRET = "BnsUser.findBySecret";
    public static final String FIND_BY_SECRET_CONTAINING ="BnsUser.findBySecretContaining";
    public static final String FIND_BY_ROLE = "BnsUser.findByRole";
    public static final String FIND_BY_TOKEN = "BnsUser.findByToken";
    public static final String FIND_BY_TOKEN_CONTAINING ="BnsUser.findByTokenContaining";
    public static final String FIND_BY_LOGINIP = "BnsUser.findByLoginIp";
    public static final String FIND_BY_LOGINIP_CONTAINING ="BnsUser.findByLoginIpContaining";
    public static final String FIND_BY_LOGINTIME = "BnsUser.findByLoginTime";
    public static final String FIND_BY_STATE = "BnsUser.findByState";
    public static final String FIND_BY_REMARK = "BnsUser.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsUser.findByRemarkContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsUser.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-company@
    @Column(name="company"  , length=64 , nullable=true , unique=false)
    private String company; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @username-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @username-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-username@
    @Column(name="username"  , length=30 , nullable=true , unique=false)
    private String username; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @password-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @password-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-password@
    @Column(name="password"  , length=60 , nullable=true , unique=false)
    private String password; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @secret-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @secret-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-secret@
    @Column(name="secret"  , length=60 , nullable=true , unique=false)
    private String secret; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @role-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @role-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-role@
    @Column(name="role"   , nullable=true , unique=false)
    private Integer role; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @token-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @token-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-token@
    @Column(name="token"  , length=100 , nullable=true , unique=false)
    private String token; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @login_ip-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @login_ip-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-login_ip@
    @Column(name="login_ip"  , length=64 , nullable=true , unique=false)
    private String loginIp; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @login_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @login_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-login_time@
    @Column(name="login_time"   , nullable=true , unique=false)
    private Timestamp loginTime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @remark-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @remark-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-remark@
    @Column(name="remark"  , length=100 , nullable=true , unique=false)
    private String remark; 
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
    public BnsUser() {
    }

	/**
	* All field constructor 
	*/
    public BnsUser(
       String id,
       String company,
       String username,
       String password,
       String secret,
       Integer role,
       String token,
       String loginIp,
       Timestamp loginTime,
       Integer state,
       String remark,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setUsername (username);
       setPassword (password);
       setSecret (secret);
       setRole (role);
       setToken (token);
       setLoginIp (loginIp);
       setLoginTime (loginTime);
       setState (state);
       setRemark (remark);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsUser flat() {
	   return new BnsUser(
          getId(),
          getCompany(),
          getUsername(),
          getPassword(),
          getSecret(),
          getRole(),
          getToken(),
          getLoginIp(),
          getLoginTime(),
          getState(),
          getRemark(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-company@
    public String getCompany() {
        return company;
    }
	
    public void setCompany (String company) {
        this.company =  company;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-username@
    public String getUsername() {
        return username;
    }
	
    public void setUsername (String username) {
        this.username =  username;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-password@
    public String getPassword() {
        return password;
    }
	
    public void setPassword (String password) {
        this.password =  password;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-secret@
    public String getSecret() {
        return secret;
    }
	
    public void setSecret (String secret) {
        this.secret =  secret;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-role@
    public Integer getRole() {
        return role;
    }
	
    public void setRole (Integer role) {
        this.role =  role;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-token@
    public String getToken() {
        return token;
    }
	
    public void setToken (String token) {
        this.token =  token;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-login_ip@
    public String getLoginIp() {
        return loginIp;
    }
	
    public void setLoginIp (String loginIp) {
        this.loginIp =  loginIp;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-login_time@
    public Timestamp getLoginTime() {
        return loginTime;
    }
	
    public void setLoginTime (Timestamp loginTime) {
        this.loginTime =  loginTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-state@
    public Integer getState() {
        return state;
    }
	
    public void setState (Integer state) {
        this.state =  state;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-remark@
    public String getRemark() {
        return remark;
    }
	
    public void setRemark (String remark) {
        this.remark =  remark;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_user@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (role==null) role=__DEFAULT_ROLE;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_user@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (role==null) role=__DEFAULT_ROLE;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
