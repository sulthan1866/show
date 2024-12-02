exports.handler = async () => {
  const password = process.env.PASSWORD;
  return {
    statusCode: 200,
    body: JSON.stringify({ password }),
  };
};
