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
	* - time      : 2016/12/22 ��Ԫ at 22:51:09 CST
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
 * <p>Title: BnsWallet</p>
 *
 * <p>Description: Domain Object describing a BnsWallet entity</p>
 *
 */
@Entity (name="BnsWallet")
@Table (name="bns_wallet")
@NamedQueries({
	 @NamedQuery(name="BnsWallet.findAll", query="SELECT bnswallet FROM BnsWallet bnswallet")
	,@NamedQuery(name="BnsWallet.findByHistory", query="SELECT bnswallet FROM BnsWallet bnswallet WHERE bnswallet.history = :history")

	,@NamedQuery(name="BnsWallet.findByMoney", query="SELECT bnswallet FROM BnsWallet bnswallet WHERE bnswallet.money = :money")

	,@NamedQuery(name="BnsWallet.findByVice", query="SELECT bnswallet FROM BnsWallet bnswallet WHERE bnswallet.vice = :vice")

	,@NamedQuery(name="BnsWallet.findByCreatedTime", query="SELECT bnswallet FROM BnsWallet bnswallet WHERE bnswallet.createdTime = :createdTime")

})

public class BnsWallet implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final java.math.BigDecimal __DEFAULT_HISTORY = java.math.BigDecimal.valueOf(0.00);
	public static final java.math.BigDecimal __DEFAULT_MONEY = java.math.BigDecimal.valueOf(0.00);
	public static final java.math.BigDecimal __DEFAULT_VICE = java.math.BigDecimal.valueOf(0.00);

    public static final String FIND_ALL = "BnsWallet.findAll";
    public static final String FIND_BY_HISTORY = "BnsWallet.findByHistory";
    public static final String FIND_BY_MONEY = "BnsWallet.findByMoney";
    public static final String FIND_BY_VICE = "BnsWallet.findByVice";
    public static final String FIND_BY_CREATEDTIME = "BnsWallet.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @history-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @history-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-history@
    @Column(name="history"   , nullable=true , unique=false)
    private java.math.BigDecimal history; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @vice-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @vice-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-vice@
    @Column(name="vice"   , nullable=true , unique=false)
    private java.math.BigDecimal vice; 
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
    public BnsWallet() {
    }

	/**
	* All field constructor 
	*/
    public BnsWallet(
       String id,
       java.math.BigDecimal history,
       java.math.BigDecimal money,
       java.math.BigDecimal vice,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setHistory (history);
       setMoney (money);
       setVice (vice);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsWallet flat() {
	   return new BnsWallet(
          getId(),
          getHistory(),
          getMoney(),
          getVice(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-history@
    public java.math.BigDecimal getHistory() {
        return history;
    }
	
    public void setHistory (java.math.BigDecimal history) {
        this.history =  history;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-vice@
    public java.math.BigDecimal getVice() {
        return vice;
    }
	
    public void setVice (java.math.BigDecimal vice) {
        this.vice =  vice;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_wallet@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (history==null) history=__DEFAULT_HISTORY;
        if (money==null) money=__DEFAULT_MONEY;
        if (vice==null) vice=__DEFAULT_VICE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_wallet@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (history==null) history=__DEFAULT_HISTORY;
        if (money==null) money=__DEFAULT_MONEY;
        if (vice==null) vice=__DEFAULT_VICE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
