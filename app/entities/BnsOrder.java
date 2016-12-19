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
	* - time      : 2016/12/20 ��Ԫ at 00:23:43 CST
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
 * <p>Title: BnsOrder</p>
 *
 * <p>Description: Domain Object describing a BnsOrder entity</p>
 *
 */
@Entity (name="BnsOrder")
@Table (name="bns_order")
@NamedQueries({
	 @NamedQuery(name="BnsOrder.findAll", query="SELECT bnsorder FROM BnsOrder bnsorder")
	,@NamedQuery(name="BnsOrder.findByCode", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.code = :code")
	,@NamedQuery(name="BnsOrder.findByCodeContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.code like :code")

	,@NamedQuery(name="BnsOrder.findByCity", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.city = :city")
	,@NamedQuery(name="BnsOrder.findByCityContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.city like :city")

	,@NamedQuery(name="BnsOrder.findByTakeTime", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.takeTime = :takeTime")

	,@NamedQuery(name="BnsOrder.findByCreatedUser", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUser = :createdUser")
	,@NamedQuery(name="BnsOrder.findByCreatedUserContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUser like :createdUser")

	,@NamedQuery(name="BnsOrder.findByCreatedUserName", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUserName = :createdUserName")
	,@NamedQuery(name="BnsOrder.findByCreatedUserNameContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUserName like :createdUserName")

	,@NamedQuery(name="BnsOrder.findByAcceptUser", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUser = :acceptUser")
	,@NamedQuery(name="BnsOrder.findByAcceptUserContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUser like :acceptUser")

	,@NamedQuery(name="BnsOrder.findByAcceptUserName", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUserName = :acceptUserName")
	,@NamedQuery(name="BnsOrder.findByAcceptUserNameContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUserName like :acceptUserName")

	,@NamedQuery(name="BnsOrder.findByMoney", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.money = :money")

	,@NamedQuery(name="BnsOrder.findByPayment", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.payment = :payment")
	,@NamedQuery(name="BnsOrder.findByPaymentContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.payment like :payment")

	,@NamedQuery(name="BnsOrder.findByDoUser", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.doUser = :doUser")
	,@NamedQuery(name="BnsOrder.findByDoUserContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.doUser like :doUser")

	,@NamedQuery(name="BnsOrder.findByState", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.state = :state")

	,@NamedQuery(name="BnsOrder.findByCreatedTime", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdTime = :createdTime")

})

public class BnsOrder implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final java.math.BigDecimal __DEFAULT_MONEY = java.math.BigDecimal.valueOf(0.00);
	public static final String __DEFAULT_DO_USER = new String("0");
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsOrder.findAll";
    public static final String FIND_BY_CODE = "BnsOrder.findByCode";
    public static final String FIND_BY_CODE_CONTAINING ="BnsOrder.findByCodeContaining";
    public static final String FIND_BY_CITY = "BnsOrder.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="BnsOrder.findByCityContaining";
    public static final String FIND_BY_TAKETIME = "BnsOrder.findByTakeTime";
    public static final String FIND_BY_CREATEDUSER = "BnsOrder.findByCreatedUser";
    public static final String FIND_BY_CREATEDUSER_CONTAINING ="BnsOrder.findByCreatedUserContaining";
    public static final String FIND_BY_CREATEDUSERNAME = "BnsOrder.findByCreatedUserName";
    public static final String FIND_BY_CREATEDUSERNAME_CONTAINING ="BnsOrder.findByCreatedUserNameContaining";
    public static final String FIND_BY_ACCEPTUSER = "BnsOrder.findByAcceptUser";
    public static final String FIND_BY_ACCEPTUSER_CONTAINING ="BnsOrder.findByAcceptUserContaining";
    public static final String FIND_BY_ACCEPTUSERNAME = "BnsOrder.findByAcceptUserName";
    public static final String FIND_BY_ACCEPTUSERNAME_CONTAINING ="BnsOrder.findByAcceptUserNameContaining";
    public static final String FIND_BY_MONEY = "BnsOrder.findByMoney";
    public static final String FIND_BY_PAYMENT = "BnsOrder.findByPayment";
    public static final String FIND_BY_PAYMENT_CONTAINING ="BnsOrder.findByPaymentContaining";
    public static final String FIND_BY_DOUSER = "BnsOrder.findByDoUser";
    public static final String FIND_BY_DOUSER_CONTAINING ="BnsOrder.findByDoUserContaining";
    public static final String FIND_BY_STATE = "BnsOrder.findByState";
    public static final String FIND_BY_CREATEDTIME = "BnsOrder.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-code@
    @Column(name="code"  , length=30 , nullable=true , unique=false)
    private String code; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @city-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @city-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-city@
    @Column(name="city"  , length=64 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @take_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @take_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-take_time@
    @Column(name="take_time"   , nullable=true , unique=false)
    private Timestamp takeTime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_user@
    @Column(name="created_user"  , length=64 , nullable=true , unique=false)
    private String createdUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_user_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_user_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_user_name@
    @Column(name="created_user_name"  , length=64 , nullable=true , unique=false)
    private String createdUserName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accept_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accept_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accept_user@
    @Column(name="accept_user"  , length=64 , nullable=true , unique=false)
    private String acceptUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accept_user_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accept_user_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accept_user_name@
    @Column(name="accept_user_name"  , length=30 , nullable=true , unique=false)
    private String acceptUserName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @payment-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @payment-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-payment@
    @Column(name="payment"  , length=30 , nullable=true , unique=false)
    private String payment; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @do_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @do_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-do_user@
    @Column(name="do_user"  , length=100 , nullable=true , unique=false)
    private String doUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
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
    public BnsOrder() {
    }

	/**
	* All field constructor 
	*/
    public BnsOrder(
       String id,
       String code,
       String city,
       Timestamp takeTime,
       String createdUser,
       String createdUserName,
       String acceptUser,
       String acceptUserName,
       java.math.BigDecimal money,
       String payment,
       String doUser,
       Integer state,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCode (code);
       setCity (city);
       setTakeTime (takeTime);
       setCreatedUser (createdUser);
       setCreatedUserName (createdUserName);
       setAcceptUser (acceptUser);
       setAcceptUserName (acceptUserName);
       setMoney (money);
       setPayment (payment);
       setDoUser (doUser);
       setState (state);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsOrder flat() {
	   return new BnsOrder(
          getId(),
          getCode(),
          getCity(),
          getTakeTime(),
          getCreatedUser(),
          getCreatedUserName(),
          getAcceptUser(),
          getAcceptUserName(),
          getMoney(),
          getPayment(),
          getDoUser(),
          getState(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-city@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-take_time@
    public Timestamp getTakeTime() {
        return takeTime;
    }
	
    public void setTakeTime (Timestamp takeTime) {
        this.takeTime =  takeTime;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_user_name@
    public String getCreatedUserName() {
        return createdUserName;
    }
	
    public void setCreatedUserName (String createdUserName) {
        this.createdUserName =  createdUserName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accept_user@
    public String getAcceptUser() {
        return acceptUser;
    }
	
    public void setAcceptUser (String acceptUser) {
        this.acceptUser =  acceptUser;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accept_user_name@
    public String getAcceptUserName() {
        return acceptUserName;
    }
	
    public void setAcceptUserName (String acceptUserName) {
        this.acceptUserName =  acceptUserName;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-payment@
    public String getPayment() {
        return payment;
    }
	
    public void setPayment (String payment) {
        this.payment =  payment;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-do_user@
    public String getDoUser() {
        return doUser;
    }
	
    public void setDoUser (String doUser) {
        this.doUser =  doUser;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_order@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (money==null) money=__DEFAULT_MONEY;
        if (doUser==null) doUser=__DEFAULT_DO_USER;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_order@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (money==null) money=__DEFAULT_MONEY;
        if (doUser==null) doUser=__DEFAULT_DO_USER;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
