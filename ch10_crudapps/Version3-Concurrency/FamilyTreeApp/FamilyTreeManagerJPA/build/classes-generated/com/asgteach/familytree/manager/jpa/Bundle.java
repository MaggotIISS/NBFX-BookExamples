package com.asgteach.familytree.manager.jpa;
/** Localizable strings for {@link com.asgteach.familytree.manager.jpa}. */
@javax.annotation.Generated(value="org.netbeans.modules.openide.util.NbBundleProcessor")
class Bundle {
    /**
     * @return <i>Error</i>
     * @see FamilyTreeManagerJPA
     */
    static String DBError() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "DBError");
    }
    /**
     * @return <i>Cannot get EntityManager.</i>
     * @see FamilyTreeManagerJPA
     */
    static String DBServerEntityError() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "DBServerEntityError");
    }
    /**
     * @return <i>Perhaps you forgot to start JavaDB Database Server?</i>
     * @see FamilyTreeManagerJPA
     */
    static String DBServerFailure() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "DBServerFailure");
    }
    private Bundle() {}
}
