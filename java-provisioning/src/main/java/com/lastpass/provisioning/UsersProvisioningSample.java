package com.lastpass.provisioning;

import com.lastpass.provisioning.model.Group;
import com.lastpass.provisioning.model.User;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.apache.log4j.PropertyConfigurator;

/**
 * A sample that shows how to use UsersProvisioning class
 *
 * @author LogMeIn
 */
public class UsersProvisioningSample {

    private static final int RANDOM_ID = new SecureRandom().nextInt();
    private static final String USERNAME = "john.smith" + RANDOM_ID + "@test.example.com";
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";
    private static final String GROUP_NAME = "TEST GROUP " + RANDOM_ID;
    private static final String ROLE = "TEST ROLE " + RANDOM_ID;

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure(UsersProvisioningSample.class.getResource("/conf/log4j.properties").getPath());
        String publicKey = UsersProvisioningSample.class.getResource("/conf/public-key.pem").getPath();
        String privateKey = UsersProvisioningSample.class.getResource("/conf/private-key.pem").getPath();
        Properties props = new Properties();
        props.load(UsersProvisioning.class.getResourceAsStream("/conf/config.properties"));
        UsersProvisioning provisioning = new UsersProvisioning(
                publicKey, privateKey, props.getProperty("generic_api_key"), props.getProperty("provisioning_url"));

        User user = new User(USERNAME, FIRST_NAME, LAST_NAME);

        //group sample
//        Map<String, String> group = new HashMap<>();
//        group.put("Name", GROUP);
//        group.put("OrganizationalUnit", "Org unit");
        Group group = new Group(GROUP_NAME);
        
        System.out.println(provisioning.getGroups(100 ,0));
        
        if(true)return;

        //group member sample
        Map<String, String> groupMember = new HashMap<>();
        groupMember.put("GroupName", group.getName());
        groupMember.put("MemberName", user.getEmail());

        //role sample
        Map<String, String> role = new HashMap<>();
        role.put("Name", "Test Role");

        System.out.println("\nadd/edit user");
        if (provisioning.isUserExists(user.getEmail())) {
            if (provisioning.editUser(user)) {
                System.out.println("user edited");
            }
        } else {
            if (provisioning.addUser(user)) {
                System.out.println("user added");
            }
        }

        System.out.println("\nadd group");
        String groupId = provisioning.addGroup(group);

        if (groupId != null) {
            System.out.println("group added: " + groupId);
        }

        System.out.println("\nadd group member");
        if (provisioning.assignGroupMember(groupMember)) {
            System.out.println("group member assigned");
        }

        System.out.println("\nresend activation email");
        if (provisioning.resendActivationEmail(user.getEmail())) {
            System.out.println("activation email has been sent");
        }

        System.out.println("\nadd role");
        String roleId = provisioning.postRole(role);

        if (roleId != null) {
            System.out.println("role added: " + roleId);
        }

        System.out.println("\nadd items to role");
        Map<String, Object> roleItems = new HashMap<>();
        roleItems.put("Code", roleId);
        roleItems.put("Users", new String[]{user.getEmail()});
        roleItems.put("Groups", new String[]{group.getName()});

        if (provisioning.assignToRole(roleItems)) {
            System.out.println("role items assigned");
        }

        System.out.println("\nget roles");
        Map<String, Object> result = provisioning.getRoles(100, 0);
        System.out.println("Total: " + result.get("Total"));
        System.out.println(result.get("Items"));

        System.out.println("\nget role items");
        Map<String, List<String>> items = provisioning.getAssignedToRole(roleId);
        System.out.print("Users: ");
        items.get("Users").forEach((u) -> {
            System.out.print(u + " ");
        });
        System.out.print("\nGroups: ");
        items.get("Groups").forEach((g) -> {
            System.out.print(g + " ");
        });

        System.out.println("\n\ndelete role");
        if (provisioning.deleteRole(roleId)) {
            System.out.println("role deleted");
        }

        System.out.println("\nsuspend user");
        if (provisioning.suspendUser(user.getEmail())) {
            System.out.println("user suspended");
        }

        System.out.println("\ndelete group member");
        if (provisioning.unassignGroup(groupMember)) {
            System.out.println("group member deleted");
        }

        System.out.println("\ndelete group");
        if (provisioning.deleteGroup(group.getName())) {
            System.out.println("group deleted");
        }

        System.out.println("\ndelete user");
        if (provisioning.deleteUser(user.getEmail())) {
            System.out.println("user deleted");
        }
    }

}
