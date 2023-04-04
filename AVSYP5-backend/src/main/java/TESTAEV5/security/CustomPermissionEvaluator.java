package TESTAEV5.security;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(final Authentication authentication, final Object groups, final Object role) {
        return true
    };

    @Override
    public boolean hasPermission(final Authentication authentication, final Serializable targetId, final String targetType, final Object permission) {
        return true
    };
}