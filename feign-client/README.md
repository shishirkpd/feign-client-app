### why use Feign
1. we don't need to learn any new syntax, we can use the same Spring MVC annotations like (@RequestMapping, @PathVariable, @RequestParam, @RequestBody, @ResponseBody, @RequestHeader, and @ResponseHeader ...).
2. easy to read and maintain, Feign abstracts the implementation of how requests are made, and you just need to care about configuration.
3. each Feign client is composed of a set of customizable components. These components are
Decoder: process the incoming server response to transform it into our desired object, It uses a ResponseEntityDecoder.
Encoder: we must process our outgoing object before calling the other service, the default one here is SpringEncoder.
Logger: For our application, we may set the logging level we wish. These logs are only available in DEBUG mode, and any implementation that extends the Slf4jLogger can be provided.
Contract: defines which annotations will be valid on our clients, for our examples, we are using SpringMvcContract to enable Spring MVC annotations.
4. customizing Feign components (Encoder , Retryer)
5. handle errors using Feign ErrorDecoder