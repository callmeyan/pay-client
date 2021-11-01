package me.xiaoyan.pay;

import me.xiaoyan.pay.vo.PayRecord;
import me.xiaoyan.pay.vo.QueryOrder;

class PayClientTest {
    private static final Integer MCH_ID= 20002;
    private static final String KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCSZrmcZut78zfKT3b9Kqbk1gmnD7wuZe1wNg2E+ttC2ymuVh7vmOF4tXvmuTOd/XF5huGndK+3zUg2m+PRtNFfi7HQ7dWc0FFRVaZ3QSX6nMb8FAbzJCrYC5SsqYCJHvbeiMFStjFwWzK1pgKuTPLIc6MqGMcujudIr/94/jzmRIu1m7eU7SRsZ82cKd8edaLs4RNkIF7x3X+mt3S4aKzyXH1tDKLgz6v/XXBPqF/UXQkVe8jhyE+IF8BvUIiFkeNhZaXc79DOAEkUYXPK3n+l5f6bh6vNPM7/S1AFrnxg5GDg1hBBG3+V6SUFaClorWQkNgrHs5rhhgSmQEgXqka5AgMBAAECggEAMvBhNsUsvGUFDXSWz0HO7iJ3G1TDQlWexwNXsuRh9CIzn4BBpVZJZWmoIcBg8GDl4cYHr+9O0KIxtSaKn0XN7/O4PBz0zWpCUQ1/LVFSuJ9iMQV64ZC9A40L/wO/QHawqP9mXLQeAZ0JyOBpYGJPu2VY6WXTsCRy3vy15FB5uhin9IXJEei48Vvk4vlGyTXmoR67qYz4LaiLTV3sTdHXpzOuOCgG19du5rXv0odSh5zyOLBHTzjU9NkrtrXqEfYJb9sziw9q/2B+r7ABZeMmoQKAToapvgau69D4viUOTOGLxvpmzn0UWnVG7wO9XPj3HAFc1rIiL6buH0m1EC7DrQKBgQDuBvxbNixGsJo0tljIAK1KCT7V3eLCmquv6vmffeNpvGloqKkLTs6cFMZ65E0+uOfIl1jSdJGDzk0uQw1NXIVDrH/paj2pjNuRb7WscXdu8zLBYGWK5uiZxFhooCV62G7OXjbLxk9Q6g2kQz1sXuYncTS4xeGi2ERC76JL72YsAwKBgQCddKD7ZfOzqql0wsP4F3/NgsRCZL6hN5VnK30PJkQhu4fw5mcg4l9KNAZPK7X2iWfqpaYIeS4U+5yDYKlLZTj/g/y5RJmWwmDhRPe/g6dAynzjP+HrrY0gmfXwpWIRMeGqcIAa2krR7wIBerO+V/2BauQ2Jz0d5+a+x9/TNDOrkwKBgCt3mx4NBojiN0bpBc2AUiTzC0aC/qYLGM9HWc6GbsEgZx91rWkjOxfFs3k9t918Ztd6y/2iy/AF/JI2LHe0LaHuHm3BuQD9eBtXCxYyolzgjKRDtkdnY5KxCHQSysVkQNfu3JLZ5CIim9sjbFQeAGmzgq07dbkHRW/z0u+LCF2BAoGAA50JlLtiPF1ORj+x/5+Kb0zw9BUbytdbtmJpHE/kgGGtXPnso/SN+0X2XxrBska0+82RYeBmDlU34kv1lqVcCYEd66KHY85SKtlKVjrPO81p0E1HAgGZm4Xs/vjMp1hdtWufhP49eVPi1+XY+iVKzA2H7zY3UNhhkz9DA7XO+cECgYBOmN0CN0DGHCuYoeOzI5BH2Fzyvsbhuyrj7fsy76XVkKuwFE7+tjYAu0vrmSIfOePAlU4VgyKf2cnuQZsXCcoc5CFqLwlwneGzI8OJbAzkDs4CewJRZJgwz02hSe886AB93a3+/aAOIrPNpqbFfckUFBqT74FfjyO+YP76K2oH6Q==";
    public static void main(String[] args) {
        PayClient client = PayClient.getClient(MCH_ID,"",KEY,"http://localhost:8088");
        QueryOrder q = new QueryOrder();
        q.setTradeNo("20211026205000247");
        try {
            PayRecord query = client.query(q);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
