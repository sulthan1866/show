exports.handler = async () => {
  const api = process.env.API;
  return {
    statusCode: 200,
    body: JSON.stringify({ api }),
  };
};
