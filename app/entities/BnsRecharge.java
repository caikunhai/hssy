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
	* - time      : 2016/12/24 ��Ԫ at 10:04:07 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsRecharge</p>
 *
 * <p>Description: Domain Object describing a BnsRecharge entity</p>
 *
 */
@Entity (name="BnsRecharge")
@Table (name="bns_recharge")
@NamedQueries({
	 @NamedQuery(name="BnsRecharge.findAll", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge")
	,@NamedQuery(name="BnsRecharge.findByCode", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.code = :code")
	,@NamedQuery(name="BnsRecharge.findByCodeContaining", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.code like :code")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsRecharge.findByActual", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.actual = :actual")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsRecharge.findByAllowance", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.allowance = :allowance")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsRecharge.findByState", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.state = :state")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsRecharge.findByCreatedUser", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.createdUser = :createdUser")
	,@NamedQuery(name="BnsRecharge.findByCreatedUserContaining", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.createdUser like :createdUser")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsRecharge.findByCreatedTime", query="SELECT bnsrecharge FROM BnsRecharge bnsrecharge WHERE bnsrecharge.createdTime = :createdTime")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
})
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-annotations@
//MP-MANAGED-ADDED-AREA-ENDING @custom-annotations@
public class BnsRecharge implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final java.math.BigDecimal __DEFAULT_ACTUAL = java.math.BigDecimal.valueOf(0.00);
	public static final java.math.BigDecimal __DEFAULT_ALLOWANCE = java.math.BigDecimal.valueOf(0.00);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsRecharge.findAll";
    public static final String FIND_BY_CODE = "BnsRecharge.findByCode";
    public static final String FIND_BY_CODE_CONTAINING ="BnsRecharge.findByCodeContaining";
    public static final String FIND_BY_ACTUAL = "BnsRecharge.findByActual";
    public static final String FIND_BY_ALLOWANCE = "BnsRecharge.findByAllowance";
    public static final String FIND_BY_STATE = "BnsRecharge.findByState";
    public static final String FIND_BY_CREATEDUSER = "BnsRecharge.findByCreatedUser";
    public static final String FIND_BY_CREATEDUSER_CONTAINING ="BnsRecharge.findByCreatedUserContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsRecharge.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-code@
    @Column(name="code"  , length=30 , nullable=true , unique=false)
    private String code; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @actual-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @actual-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-actual@
    @Column(name="actual"   , nullable=true , unique=false)
    private java.math.BigDecimal actual; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @allowance-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @allowance-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-allowance@
    @Column(name="allowance"   , nullable=true , unique=false)
    private java.math.BigDecimal allowance; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
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
    public BnsRecharge() {
    }

	/**
	* All field constructor 
	*/
    public BnsRecharge(
       String id,
       String code,
       java.math.BigDecimal actual,
       java.math.BigDecimal allowance,
       Integer state,
       String createdUser,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCode (code);
       setActual (actual);
       setAllowance (allowance);
       setState (state);
       setCreatedUser (createdUser);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsRecharge flat() {
	   return new BnsRecharge(
          getId(),
          getCode(),
          getActual(),
          getAllowance(),
          getState(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-actual@
    public java.math.BigDecimal getActual() {
        return actual;
    }
	
    public void setActual (java.math.BigDecimal actual) {
        this.actual =  actual;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-allowance@
    public java.math.BigDecimal getAllowance() {
        return allowance;
    }
	
    public void setAllowance (java.math.BigDecimal allowance) {
        this.allowance =  allowance;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_recharge@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (actual==null) actual=__DEFAULT_ACTUAL;
        if (allowance==null) allowance=__DEFAULT_ALLOWANCE;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_recharge@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (actual==null) actual=__DEFAULT_ACTUAL;
        if (allowance==null) allowance=__DEFAULT_ALLOWANCE;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
