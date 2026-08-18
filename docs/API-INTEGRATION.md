# Integración real de Inteli Social

## Objetivo
La APK nunca almacena secretos de Meta o LinkedIn. Se conecta a un backend de Inteli Social que administra OAuth, tokens, publicación y métricas.

## Endpoints previstos
- GET /api/social/accounts
- GET /api/social/instagram/auth
- GET /api/social/linkedin/auth
- GET /api/social/metrics/instagram
- GET /api/social/metrics/linkedin
- POST /api/social/posts
- GET /api/social/posts
- DELETE /api/social/posts/:id

## Instagram
Usar API oficial de Meta para cuentas profesionales. OAuth y tokens viven en backend.

## LinkedIn
Usar OAuth/API oficial de LinkedIn. Los permisos efectivos dependen del producto/acceso aprobado para la aplicación.

## Estado actual
La interfaz Android ya presenta Dashboard, Métricas, Publicar y Cuentas. La siguiente fase implementa el backend y conecta los botones OAuth.