### Spring Framework upgrades { data-toc-label="Spring Framework upgrades" }

The Spring Framework upgrade recipes migrate between consecutive supported Spring Framework versions. Each recipe applies OpenRewrite's migration for its target version without rerunning earlier upgrade recipes.

| From | To  |
|------|-----|
| 4.0  | 5.0 |
| 5.0  | 5.1 |
| 5.1  | 5.2 |
| 5.2  | 5.3 |
| 5.3  | 6.0 |
| 6.0  | 6.1 |
| 6.1  | 6.2 |
| 6.2  | 7.0 |

Run an upgrade by specifying its source and target versions:

```bash
allwrite run springFramework/upgrade 6.1 6.2
```
