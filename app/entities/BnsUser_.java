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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2016/11/15 ��Ԫ at 20:16:30 CST
*/
package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BnsUser.class)
public class BnsUser_ {

    public static volatile SingularAttribute<BnsUser, String> id;

    public static volatile SingularAttribute<BnsUser, String> company;
    public static volatile SingularAttribute<BnsUser, String> username;
    public static volatile SingularAttribute<BnsUser, String> password;
    public static volatile SingularAttribute<BnsUser, String> secret;
    public static volatile SingularAttribute<BnsUser, Integer> role;
    public static volatile SingularAttribute<BnsUser, String> token;
    public static volatile SingularAttribute<BnsUser, String> loginIp;
    public static volatile SingularAttribute<BnsUser, Timestamp> loginTime;
    public static volatile SingularAttribute<BnsUser, Integer> state;
    public static volatile SingularAttribute<BnsUser, String> remark;
    public static volatile SingularAttribute<BnsUser, Timestamp> createdTime;




}
